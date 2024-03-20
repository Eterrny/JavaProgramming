package ru.sgu;

import java.io.*;
import java.util.zip.*;

public class Archiver {
    private File directory;
    private String targetString;

    public Archiver(String directoryPath, String targetString) {
        this.directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            System.err.println("Error: передан некорректный путь.");
            return;
        }
        this.targetString = targetString.toLowerCase();
    }

    public void archive() {
        File[] files = directory.listFiles();
        if (files == null) {
            System.err.println("Error: Ошибка в получении файлов директории.");
            return;
        }
        try {
            FileOutputStream fos = new FileOutputStream(directory.getName() + ".zip");
            ZipOutputStream zos = new ZipOutputStream(fos);
            for (File file : files) {
                if (file.isDirectory()) {
                    processDirectory(file, zos, "");
                } else if (file.getName().toLowerCase().contains(targetString)) {
                    zipFile(file, zos, "");
                }
            }
            zos.close();
            fos.close();
            System.out.println("Архивация завершена. Создан архив: " + directory.getName() + ".zip");
        } catch (IOException e) {
            System.err.println("Ошибка при архивации: " + e.getMessage());
        }
    }

    private void processDirectory(File directory, ZipOutputStream zos, String parentPath) throws IOException {
        if (directory.getName().toLowerCase().contains(targetString)) {
            zipDirectory(directory, zos, parentPath);
            return;
        }
        String currentPath = parentPath + directory.getName() + "/";
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    processDirectory(file, zos, currentPath);
                } else if (file.getName().toLowerCase().contains(targetString)) {
                    zipFile(file, zos, currentPath);
                }
            }
        }
    }

    private void zipDirectory(File directory, ZipOutputStream zos, String parentPath) throws IOException {
        String currentPath = parentPath + directory.getName() + "/";
        File[] files = directory.listFiles();
        zos.putNextEntry(new ZipEntry(currentPath));
        zos.closeEntry();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    zipDirectory(file, zos, currentPath);
                } else {
                    zipFile(file, zos, currentPath);
                }
            }
        }
    }

    private void zipFile(File file, ZipOutputStream zos, String parentPath) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ZipEntry zipEntry = new ZipEntry(parentPath + file.getName());
        zos.putNextEntry(zipEntry);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            zos.write(buffer, 0, length);
        }
        fis.close();
        zos.closeEntry();
//        System.out.println("Файл '" + file.getName() + "' был добавлен в архив.");
    }
}
