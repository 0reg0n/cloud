// Copyright (C) 2021 The Syncthing Authors.
//
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this file,
// You can obtain one at https://mozilla.org/MPL/2.0/.

//go:build noassets

package auto

import "github.com/0reg0n/cloud/lib/assets"

func Assets() map[string]assets.Asset {
	return nil
}
