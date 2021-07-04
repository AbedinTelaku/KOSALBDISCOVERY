import React, { Component } from "react";
import { Link } from "react-router-dom";

class Navbar extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: this.props.username,
    };
  }
  render() {
    // const list = this.state.elements.map((element, i) => (
    //  <li key={i}>{element}</li>
    //  ));
    return (
      <div>
        <div className="navbar navbar-light bg-light">
          <div>
            <h3>KOSALB DISCOVERY</h3>
          </div>

          <div className="navbarRightElements">
            <li>Home</li>
            <Link
              to={"/profile/" + this.state.username}
              className="navBarProfileBtn"
            >
              <li>Profile</li>
            </Link>

            <li>Reservations</li>

            <Link
              to={"/"}
              params={{ authenticated: false }}
              className="navBarProfileBtn"
            >
              <li>Log out</li>
            </Link>
          </div>
        </div>
      </div>
    );
  }
}

export default Navbar;
