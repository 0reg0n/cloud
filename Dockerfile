ARG GOVERSION=latest

#
# Maybe build cloud. This is a bit ugly as we can't make an entire
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
RUN if [ ! -f cloud-linux-$TARGETARCH ] ; then \
    go run build.go -no-upgrade build cloud ; \
    mv cloud cloud-linux-$TARGETARCH ; \
  fi

#
# The rest of the Dockerfile uses the binary from the builder, prebuilt or
# not.
#

FROM alpine
ARG TARGETARCH

LABEL org.opencontainers.image.authors="The cloud Project" \
      org.opencontainers.image.url="https://github.com/0reg0n/cloud" \
      org.opencontainers.image.documentation="https://github.com/0reg0n/cloud" \
      org.opencontainers.image.source="https://github.com/0reg0n/cloud" \
      org.opencontainers.image.vendor="The cloud Project" \
      org.opencontainers.image.licenses="MPL-2.0" \
      org.opencontainers.image.title="cloud"

EXPOSE 8384 22000/tcp 22000/udp 21027/udp

VOLUME ["/var/cloud"]

RUN apk add --no-cache ca-certificates curl libcap su-exec tzdata

COPY --from=builder /src/cloud-linux-$TARGETARCH /bin/cloud
COPY --from=builder /src/script/docker-entrypoint.sh /bin/entrypoint.sh

ENV PUID=1000 PGID=1000 HOME=/var/cloud

HEALTHCHECK --interval=1m --timeout=10s \
  CMD curl -fkLsS -m 2 127.0.0.1:8384/rest/noauth/health | grep -o --color=never OK || exit 1

ENV STGUIADDRESS=0.0.0.0:8384
ENV STHOMEDIR=/var/cloud/config
RUN chmod 755 /bin/entrypoint.sh
ENTRYPOINT ["/bin/entrypoint.sh", "/bin/cloud"]
