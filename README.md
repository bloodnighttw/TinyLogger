# TinyLogger
Still in development.

### What is it?
A small libary for log without any third-party libary!
It's build on System.out  juand System.err ,and with some feature I need.

## Document

This libary have 2  major class.
### LoggerFactory 
A Class to generate ``Logger`` Instance.
### Logger
A Class contain ``debug``,``info``,``warm``and``error``,4 methods.
Each method have defferent usage and 


Use LoggerFactory to get a Logger Instance.

### How to use it?
FIRST,import this two classes.
```java
import io.github.bloodnighttw.tinyLogger.LoggerFactory
import io.github.bloodnighttw.tinyLogger.Logger
```
Then,Use LoggerFactory to get a ``Logger`` Instance.

``YOURNAME``: this logger name!

``DEBUG MODE``:True or false
```java
Logger logger = LoggerFactory.getLogger(YOURNAME,DEBUG MODE);
```
if you want to print a information,you can do that!
```java
logger.info(YOUR MESSENGE);
```
then it will print
```
[$TIME][$YOURNAME][INFO]:$YOUR MESSENGE
```
Note that the usage of  ``logger.warm()``is as same as ``logger.info()``

The major usage of `` logger.error()`` is almost as same as `` logger.info()`` and ``logger.warm()``,the major different is that ``logger.error()``use System.err to print.

The major usage of `` logger.debug()`` is almost as same as `` logger.info()`` and ``logger.warm()`` , but it only print when DEBUG MODE is True.


