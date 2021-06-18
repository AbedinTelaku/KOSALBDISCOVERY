import React, { Component } from "react";
import Rooms from "./Rooms";

export default class Reservation extends Component {
  state = {
    elements: ["Home", "Tourist Places", "Reservations", "Events"],
    sidebarElements: [
      "Single",
      "Double",
      "Triple",
      "Quad",
      "Twin",
      "Double-Double",
      "Suite",
      "Mini Suite",
      "President Suite",
      "Apartament",
      "Villa",
    ],
  };

  render() {
    const list = this.state.elements.map((element, i) => (
      <li key={i}>{element}</li>
    ));
    const sideBarElList = this.state.sidebarElements.map((sideelement, i) => (
      <li key={i}>{sideelement}</li>
    ));
    return (
      <div className="pageMainDiv">
        <div className="navbar navbar-light bg-light">
          <div>
            <h3>KOSALB DISCOVERY</h3>
          </div>

          <div className="navbarRightElements">{list}</div>
        </div>

        <div className="appContainer">
          <div className="sideNav">
            <p className="sideNavTitle">What room are you looking for?</p>
            {sideBarElList}
          </div>

          <div className="roomsContainer">
            <Rooms />
          </div>
        </div>
      </div>
    );
  }
}
