package example.kotlin

import io.colyseus.Client


fun main() {
    val client = Client("ws://localhost:2567")
    client.joinOrCreate(MyState::class.java, "game", callback = { room ->
        with(room) {
            println("connected to $name")

            state.onRemove = {
                println("state.onRemove")
            }

            onLeave = { code -> println("onLeave $code") }
            onError = { code, message ->
                println("onError")
                println(code)
                println(message)
            }

            onStateChange = { state, _ ->
                println("state.boo = ${state.boo}")
            }
        }
    }, onError = { e ->
        e.printStackTrace()
    })

    readLine()
}