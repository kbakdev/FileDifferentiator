# File Differentiator

Just Java and JUnit, no external libraries.

## About

In this repository, I wanted to program object-oriented, using this opportunity to showcase my skills. To this end, I coded a solution to handle 'magic numbers' for images and text files. I remembered to prepare at least basic unit tests using the JUnit library. There are various people and not everyone is honest. Some would pretend a file is a JPG, while in fact, it's a dangerous, malicious binary. This programme will make that impossible!

## Main assumptions to be met
1. You accept all extensions. No matter the extension, attempt at reading will be done.
2. You verify "magic numbers".
3. Program must say if the extension is true (a txt file is a text file, an JPG is a JPG).
4. If extension isn't handled, program honestly states so (throwing an appropriate
   exception, one that fits this situation).
5. We expect JPGs, GIFs and TXT files to be handled. Anything more is a plus.
6. If extension lies, program states: Extension is A, while actually it's a B.

## Acknowledgements
If you never heard of magic numbers, don't worry. Here are good resources to study:
1. Unix `file` command, which tells you what a file is.
2. https://en.wikipedia.org/wiki/List_of_file_signatures3.
3. https://en.wikipedia.org/wiki/File_format#Magic_number
4. https://en.wikipedia.org/wiki/Magic_number_(programming)#Magic_numbers_in_files


