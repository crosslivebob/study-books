package com.concurrency.chapter5;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FileCrawler implements Runnable {
    private final BlockingQueue<File> fileQueue;
    private final FileFilter fileFilter;
    private final File root;

    {
        fileQueue = new ArrayBlockingQueue<File>(10);
        fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return false;
            }
        };
        root = new File("D:/");
    }

    public void run() {
        try {
            crawl(root);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    private void crawl(File root) throws InterruptedException {
        File[] entries = root.listFiles(fileFilter);
        if (entries != null) {
            for (File entry : entries) {
                if (entry.isDirectory()) {
                    crawl(entry);
                } else if (!alreadyIndexed(entry)) {
                    fileQueue.put(entry);
                }
            }
        }
    }

    private boolean alreadyIndexed(File entry) {
        return false;
    }

    public class Indexer implements Runnable {
        private final BlockingQueue<File> queue;

        public Indexer(BlockingQueue<File> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                while (true) {
                    indexFile(queue.take());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void indexFile(File take) {
        }
    }
}
