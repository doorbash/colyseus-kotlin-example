import { Room, Client } from "colyseus";
import { MyState } from "./schema/MyState";

export class GameRoom extends Room<MyState> {
  onCreate() {
    var state = new MyState()
    this.setState(state)
    setInterval(() => {

      state.boo = !state.boo

      console.log(state.boo)

    }, 1000)

  }
  onJoin(client: Client, options: any) {
  }

  onLeave(client: Client, consented: boolean) {
  }
}
