Encryptomania
-------------

This is a desktop tool for playing around with symmetric encryption.

In its first instance, the goal is to offer a GUI for trying out the
[Spring project's crypto utilities](http://docs.spring.io/spring-security/site/docs/current/reference/html/crypto.html#spring-security-crypto-encryption)
, in particular for text values.

## Requirements

A Java 7+ runtime patched with the [JCE](http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html).

## Download and run

See the latest [release](https://github.com/tfnico/encryptomania/releases), or build it yourself following instructions
further down below. Inside the bin folder you should find a launcher script for your platform.

## Todos/bugs:

* Can only do one kind of encryption (AES 256 with CBC)
* Requires JCE to be installed (see https://github.com/spring-projects/spring-security/issues/2917)

## Development

This project is based on the lazybones griffon-swing-groovy template, as
portrayed in http://griffon-framework.org/guide/2.6.0/index.html

Build, test and run like this:

    gradle build
    gradle test
    gradle run

The build will produce a runnable application in various formats, dmg-app for macs, zip with a bat script for Windows.
See the build/distributions directory for built artifacts.

License is Apache 2.0, as described in the LICENSE file.

