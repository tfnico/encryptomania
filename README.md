Encryptomania
-------------

This is a Java desktop tool for playing around with encryption.

In its first instance, the goal is to offer a GUI for trying out the
Spring project's crypto utilities.

# Todos/bugs:

* Always random key, so still no queryable text
* Can only do one kind of encryption (AES 256 with CBC)
* Requires JCE to be installed (see https://github.com/spring-projects/spring-security/issues/2917)
* Does not show error messages at all (you have to check console output)
* No 'generate salt' button yet

This project is based on the lazybones griffon-swing-groovy template, as
portrayed in http://griffon-framework.org/guide/2.6.0/index.html

Build, test and run like this:

    gradle build
    gradle test
    gradle run

