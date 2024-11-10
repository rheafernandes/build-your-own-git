package de.wyag

import com.github.ajalt.clikt.core.subcommands
import de.wyag.subcommands.Init

fun main(args: Array<String>) = Git().subcommands(Init()).main(args)