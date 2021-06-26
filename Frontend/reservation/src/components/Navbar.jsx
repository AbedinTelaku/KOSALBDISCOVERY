import React, { Component } from "react";

class Navbar extends Component {
  state = {
    elements: ["Home", "Tourist Places", "Reservations", "Events"],
  };
  render() {
    const list = this.state.elements.map((element, i) => (
      <li key={i}>{element}</li>
    ));
    return (
      <div>
        <div className="navbar navbar-light bg-light">
          <div>
            <h3>KOSALB DISCOVERY</h3>
          </div>

          <div className="navbarRightElements">{list}</div>
        </div>
      </div>
    );
  }
}

export default Navbar;
