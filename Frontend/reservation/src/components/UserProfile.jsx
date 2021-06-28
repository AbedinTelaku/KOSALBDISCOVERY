import React, { Component } from "react";
import { FaMapMarkerAlt } from "react-icons/fa";
import { FaPhoneAlt } from "react-icons/fa";
import { FaAt } from "react-icons/fa";
import ReservationsTable from "./ReservationsTable";

class UserProfile extends Component {
  state = {
    business: "",
    city: "",
  };
  componentDidMount() {
    fetch(
      "http://localhost:8080/api/register/business/get/business/byUsername/" +
        this.props.match.params.username
    )
      .then((res) => res.json())
      .then((data) => {
        this.setState({ business: data, city: data.city });
        console.log();
      });
  }
  render() {
    console.log(this.props.match.params.username);
    return (
      <div className="allContent">
        <div className="userProfileContent">
          <div className="userProfileSideNav">
            <ul>
              <li>
                <a href="#reservationsTableDiv">Reservations</a>
              </li>
              <li>
                <a href="#reservationsTableDiv">Reservations</a>
              </li>
              <li>
                <a href="#reservationsTableDiv">Reservations</a>
              </li>
              <li>
                <a href="#reservationsTableDiv">Reservations</a>
              </li>
              <li>
                <a href="#reservationsTableDiv">Reservations</a>
              </li>
              <li>
                <a href="#reservationsTableDiv">Reservations</a>
              </li>
            </ul>
          </div>

          <div className="userProfileMainContent">
            <div className="userProfileData">
              <div className="userProfilePicture">
                <img
                  className="profilePicture"
                  src="https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1b/8e/d9/d8/hotel-presidente.jpg?w=1200&h=-1&s=1"
                  alt=""
                />
              </div>
              <div className="userProfileInfo">
                <h2 style={{ color: "orange", "margin-bottom": "10%" }}>
                  {this.state.business.name}
                </h2>
                <h6 style={{ "margin-bottom": "5%" }}>
                  <FaPhoneAlt style={{ color: "orange" }} />
                  {this.state.business.tel_Number}
                </h6>
                <h6 style={{ "margin-bottom": "5%" }}>
                  <FaAt style={{ color: "orange" }} />{" "}
                  {this.state.business.email}
                </h6>
                <h6>
                  <FaMapMarkerAlt style={{ color: "orange" }} />{" "}
                  {this.state.city.name}
                </h6>
              </div>
            </div>
          </div>
        </div>

        <div className="tableDiv" id="reservationsTableDiv">
          <ReservationsTable username={this.props.match.params.username} />
        </div>
      </div>
    );
  }
}

export default UserProfile;
