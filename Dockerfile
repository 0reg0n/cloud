ARG GOVERSION=latest

#
# Maybe build linkbox0. This is a bit ugly as we can't make an entire
# section of the Dockerfile conditional, so we end up always pulling
# the golang image as builder. Then we check if the executable we need
# already exists (pre-built) otherwise we build it.
#

FROM golang:$GOVERSION AS builder
ARG BUILD_USER
ARG BUILD_HOST
ARG TARGETARCH

WORKDIR /src
COPY . .

ENV CGO_ENABLED=0
RUN if [ ! -f linkbox0-linux-$TARGETARCH ] ; then \
    go run build.go -no-upgrade build linkbox0 ; \
    mv linkbox0 linkbox0-linux-$TARGETARCH ; \
  fi

#
# The rest of the Dockerfile uses the binary from the builder, prebuilt or
# not.
#

FROM alpine
ARG TARGETARCH

LABEL org.opencontainers.image.authors="The linkbox0 Project" \
      org.opencontainers.image.url="https://github.com/0reg0n/linkbox0" \
      org.opencontainers.image.documentation="https://github.com/0reg0n/linkbox0" \
      org.opencontainers.image.source="https://github.com/0reg0n/linkbox0" \
      org.opencontainers.image.vendor="The linkbox0 Project" \
      org.opencontainers.image.licenses="MPL-2.0" \
      org.opencontainers.image.title="linkbox0"

EXPOSE 8384 22000/tcp 22000/udp 21027/udp

VOLUME ["/var/linkbox0"]

RUN apk add --no-cache ca-certificates curl libcap su-exec tzdata

COPY --from=builder /src/linkbox0-linux-$TARGETARCH /bin/linkbox0
COPY --from=builder /src/script/docker-entrypoint.sh /bin/entrypoint.sh

ENV PUID=1000 PGID=1000 HOME=/var/linkbox0

HEALTHCHECK --interval=1m --timeout=10s \
  CMD curl -fkLsS -m 2 127.0.0.1:8384/rest/noauth/health | grep -o --color=never OK || exit 1

ENV STGUIADDRESS=0.0.0.0:8384
ENV STHOMEDIR=/var/linkbox0/config
RUN chmod 755 /bin/entrypoint.sh
ENTRYPOINT ["/bin/entrypoint.sh", "/bin/linkbox0"]
