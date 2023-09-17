//
// Created by bfq on 2021/11/20.
//
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/fcntl.h>
#include <string.h>
#include <wait.h>

void test_05_02();

int main() {
    test_05_02();
    return 0;
}

void test_05_02() {
    int __fd = open("./check.txt", O_CREAT | O_RDWR | O_TRUNC, S_IRWXU);
    int pid = fork();
    if (pid < 0) {
        printf("error");
        exit(1);
    } else if (pid == 0) {
        char *str = "parent test\n";
        int error = write(__fd, str, sizeof(char) * strlen(str));
        printf("parent process, pid=%d,sucess=%d\n", pid, error==-1);
    } else {
        char *str = "child test\n";
        int error = write(__fd, str, sizeof(char) * strlen(str));
        printf("child process, pid=%d,sucess=%d\n", pid, error==-1);
        int wc = wait(NULL);
        close(__fd);
    }
}


