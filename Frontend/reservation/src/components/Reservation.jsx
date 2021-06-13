import React, { Component } from "react";

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
    const list = this.state.elements.map((element) => <li>{element}</li>);
    const sideBarElList = this.state.sidebarElements.map((sideelement) => (
      <li>{sideelement}</li>
    ));
    return (
      <div>
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
            <div>
              <img src="" alt="roomPht" />
            </div>
          </div>
        </div>
      </div>
    );
  }
}
