#fileio by Pimwalun Witchawanitchanun
Task                		| Elapsed Time
----------------------------|--------------:
Copy file one byte 			| 6.236706 sec
Copy file 1 KB				| 0.082243 sec
Copy file 4 KB				| 0.016722 sec
Copy file 64 KB				| 0.015173 sec
Copy file one line			| 0.092749 sec

Copy methods at one byte uses the slowest running time because it must read one bye at a time until the end of stream.  The second one is bufferedreader because it reads one line at a time.  Then it changes from byte>byte[]>char>char[]>String.  For this reason, it spends the long time running.The fastest way is copy an array such as if we determine 1024 byte or 1 kilobyte, it will read as we do.  It won’t read one byte at a time. For this reason, it spends the fastest time running. The more arrays that are determined, the faster time will be read.
