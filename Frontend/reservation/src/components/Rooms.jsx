import React, { Component } from "react";
import Room from "./Room";

class Rooms extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rooms: [],
    };
  }

  componentDidMount() {
    fetch("http://localhost:8080/api/register/room/get/all/rooms")
      .then((res) => res.json())
      .then((data) => {
        this.setState({ rooms: data });
      });
  }

  render() {
    const allRooms = this.state.rooms.map((room) => (
      <Room
        key={room.id}
        id={room.id}
        type={room.room_type}
        price={room.price}
        discount={room.discount}
      />
    ));
    console.log(this.state.rooms);

    return <div className="roomDiv">{allRooms}</div>;
  }
}

export default Rooms;
