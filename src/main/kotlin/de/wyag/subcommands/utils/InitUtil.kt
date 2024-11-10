package de.wyag.subcommands.utils

import de.wyag.domain.GitRepository
import java.nio.file.Files
import kotlin.io.path.*

fun createRepo(path: String?) {
    val repo = GitRepository(path, true)
    if (repo.workTree.exists()) {
        if (!repo.workTree.isDirectory()) {
            throw Exception("${repo.workTree.toAbsolutePath()} is not a directory! ")
        }
        if (repo.gitDirectory.exists() && repo.gitDirectory.listDirectoryEntries().isNotEmpty()) {
            throw Exception("${repo.gitDirectory.toAbsolutePath()} is not empty!")
        } else {
            repo.gitDirectory.createDirectory()
        }
    } else {
        repo.workTree.createDirectory()
    }
    //Create various git directories
    if(!repo.gitDirectory.resolve("branches").exists()) {
        Files.createDirectories(repo.gitDirectory.resolve("branches"))
    }
    repo.gitDirectory.resolve("objects").createDirectory()
    repo.gitDirectory.resolve("refs/tags").createDirectories()
    repo.gitDirectory.resolve("refs/heads").createDirectories()

    //Create files
    val description = repo.gitDirectory.resolve("description").createFile()
    Files.writeString(description, "Unnamed repository; edit this file 'description' to name the repository.\n")
    val head = repo.gitDirectory.resolve("HEAD").createFile()
    Files.writeString(head, "ref: refs/heads/master\n")

    ConfigParser(repo.gitDirectory.resolve("config").createFile()).initConfig()

}