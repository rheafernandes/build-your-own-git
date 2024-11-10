package de.wyag

import com.github.ajalt.clikt.core.CliktCommand

class Git: CliktCommand() {
    override fun run() {
        echo("Your own git command is running.")
    }
}