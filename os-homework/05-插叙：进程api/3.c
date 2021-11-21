//
// Created by bfq on 2021/11/20.
//
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <wait.h>

void test_05_03();

int main() {
    test_05_03();
    return 0;
}

void test_05_03() {
    printf("main process starting...\n");
    int pid = fork();
    if (pid < 0) {
        printf("error");
        exit(1);
    } else if (pid == 0) {
        printf("goodbye\n");
    } else {
        int wc = wait(NULL);
        printf("hello, %d\n", wc);
    }
}

