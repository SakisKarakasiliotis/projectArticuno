fun main() : nothing
{
    puts("Hello world!");
    puts("\"Hello world!\"");
    puts("\'Hello world!\'");
    puts("\\\t\r\n\0");
    puts("Lowercase hex: \xaa\xbb\xcc\xdd\xee");

    putc('\x99');
    putc('\x9A');
    putc('\xFa');
}