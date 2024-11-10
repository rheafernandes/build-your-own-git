package de.wyag.subcommands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import de.wyag.subcommands.utils.createRepo


class Init(): CliktCommand(name ="init") {
    val path: String?  by option(help="Where to create the repository.")
    override fun run() {
        echo("Initialize a new, empty repository.")
        createRepo(path)
    }
}