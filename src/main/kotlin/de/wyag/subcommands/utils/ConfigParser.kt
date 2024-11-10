package de.wyag.subcommands.utils

import org.ini4j.Wini
import java.nio.file.Path

class ConfigParser(configPath: Path) {
    private val config = Wini(configPath.toFile())

    fun initConfig() {
        config.put("core", "repositoryformatversion", 0)
        config.put("core", "filemode", false)
        config.put("core", "bare", false)
    }

//    fun loadConfig(): Wini  {
//        return config
//    }
//
//    fun setConfigValues(): File {
//        initConfig()
//        return config.get
//    }
}
