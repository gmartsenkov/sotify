# sotify
Client tool for sending slack messages via incoming webhooks.

## Usage

``` sh
Slack notification tool.
Usage: sotify -u http://slack.hook -m "Custom message" 

Options:
  -u, --url URL          Slack webhook url
  -m, --message MESSAGE  A custom message
  -c, --channel CHANNEL  Slack channel, example: #channel or @username
  -h, --help
```

## Build
Install the [asdf version manager](https://asdf-vm.com/#/core-manage-asdf?id=install), add the `java`, `clojure` and `lein` plugins and run `asdf install` which will install the correct versions from the `.tool-versions` file.
Run `gu install native-image`, you need to make sure that the `native-image` binary is in your $PATH or alternatively create an alias like this:
``` sh
alias native-image="~/.asdf/installs/java/graalvm-21.1.0+java16/bin/native-image"
```
Run the `./build` script which will build the CLI into a binary in `./targets`

## License

Copyright © 2021 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
