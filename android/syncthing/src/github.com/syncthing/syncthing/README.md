# LinkBox0

**LinkBox0** is a continuous file synchronization program. It synchronizes files
between two or more computers, peer to peer, without a central server.

This project is based on [Syncthing](https://github.com/syncthing/syncthing) and
keeps its core functionality: continuous, decentralized, encrypted file
synchronization. The design and identity are adapted for `LinkBox0` on top of that
foundation.

## Goals

The goals inherited from the upstream foundation, in order of importance:

1. **Safe From Data Loss** — protecting the user's data is paramount.
2. **Secure Against Attackers** — never expose data to eavesdropping or
   unauthorized modification.
3. **Easy to Use** — approachable and understandable.
4. **Automatic** — user interaction only when necessary.
5. **Universally Available** — run on every common computer.
6. **For Individuals** — empower the individual user.

## Getting Started

Take a look at the [upstream getting started guide][2].

## Building

Building from source requires Go (see `go.mod` for the required version).

    go run build.go

The binary is created in the current directory as `linkbox0`. A guide with more
details is available in the [upstream build documentation][5].

## Documentation

The protocol and user documentation are inherited from upstream:

- [Syncthing documentation][6]
- [BEP protocol specification][1]

## Attribution and License

`LinkBox0` is a derivative work of Syncthing, which is licensed under the
[Mozilla Public License 2.0][7]. Files originating from Syncthing retain their
original copyright notices and are distributed under the same license. See
[NOTICE](NOTICE) for details.

[1]: https://docs.syncthing.net/specs/bep-v1.html
[2]: https://docs.syncthing.net/intro/getting-started.html
[5]: https://docs.syncthing.net/dev/building.html
[6]: https://docs.syncthing.net/
[7]: LICENSE
