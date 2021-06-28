import React, { Component } from "react";
import { FaMapMarkerAlt } from "react-icons/fa";
import { FaPhoneAlt } from "react-icons/fa";
import { FaAt } from "react-icons/fa";
import ReservationsTable from "./ReservationsTable";

class UserProfile extends Component {
  state = {};
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
                <h2 style={{ color: "orange" }}>User Name</h2>
                <h6>
                  <FaPhoneAlt style={{ color: "orange" }} />
                  Phone number
                </h6>
                <h6>
                  <FaAt style={{ color: "orange" }} /> email address
                </h6>
                <h6>
                  <FaMapMarkerAlt style={{ color: "orange" }} /> address
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
