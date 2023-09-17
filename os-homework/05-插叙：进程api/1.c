#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

void test_05_01();

int main() {
    test_05_01();
    return 0;
}

void test_05_01() {
    int x = 0;
    printf("main process x=%d\n", x);
    int pid = fork();
    if (pid < 0) {
        printf("error");
        exit(1);
    } else if (pid == 0) {
        x = 300;
        printf("parent process, pid=%d,x=%d\n", pid, x);
    } else {
        x = 200;
        printf("child process, pid=%d,x=%d\n", pid, x);
    }
}
