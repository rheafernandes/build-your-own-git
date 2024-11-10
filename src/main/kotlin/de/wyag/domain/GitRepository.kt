package de.wyag.domain

import org.ini4j.Wini
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.exists
import kotlin.io.path.isDirectory

class GitRepository(path: String?, force: Boolean = false) {
    val workTree: Path
    val gitDirectory: Path
    val config: Wini?
    init {
        workTree = if (path == null) Paths.get(System.getProperty("user.dir")) else Paths.get(path)
        gitDirectory = workTree.resolve(".git")
        // validate git directory
        if (!(force or gitDirectory.isDirectory())) {
            throw Exception("Not a Git repository : ${gitDirectory.toAbsolutePath()}")
        }
        val configPath = gitDirectory.resolve("config")
        config = if (configPath.exists()) {
            Wini(configPath.toFile())
        } else if(!force){
            throw Exception("Configuration file missing")
        } else {
            null
        }

        if (!force) {
            val version = config?.get("core", "repositoryformatversion")?.toInt()
            if (version != 0) {
                throw Exception("Unsupported repository format version: $version")
            }
        }
    }
}