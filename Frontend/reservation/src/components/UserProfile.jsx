import React, { Component } from "react";
import { FaMapMarkerAlt } from "react-icons/fa";
import { FaPhoneAlt } from "react-icons/fa";
import { FaAt } from "react-icons/fa";
import ReservationsTable from "./ReservationsTable";
import RoomType from "./RoomType";

class UserProfile extends Component {
  state = {
    business: "",
    city: "",
    roomTypes: [],
    reservations: [],
    reservationId: "",
    reservationsProfits: "",
    bUsername: this.props.match.params.username,
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

    fetch(
      "http://localhost:8008/api/reservation/get/reservations/" +
        this.props.match.params.username
    )
      .then((res) => res.json())
      .then((data) => {
        this.setState({ reservations: data, reservationId: data.id });
      });

    fetch(
      "http://localhost:8080/api/register/room/get/roomtypes/" +
        this.props.match.params.username
    )
      .then((res) => res.json())
      .then((data) => {
        this.setState({ roomTypes: data });
      });
  }

  printReservationsStats(username) {
    window.open(
      "http://localhost:8008/api/reservation/export/reservations/PDF/" +
        username
    );
  }

  render() {
    //  <div className="roomTypeDiv">
    // <p key={i} id={roomType}>
    //  {roomType}
    // </p>
    //</div>

    console.log(this.props.match.params.username);
    console.log(this.state.roomTypes);
    const roomTypesList = this.state.roomTypes.map((roomType, i) => (
      <RoomType
        key={i}
        id={roomType}
        businessUsername={this.props.match.params.username}
      />
    ));
    let totalProfits = 0;
    const profit = this.state.reservations.map((reservation) => {
      return (totalProfits = totalProfits + reservation.totalPrice);
    });
    return (
      <div className="allContent">
        <div className="userProfileContent">
          <div className="userProfileSideNav">
            <ul>
              <li>
                <a href="#reservationsTableDiv">Reservations</a>
              </li>
              <li>
                <a href="#reports">Stats</a>
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
        <div className="businessReports" id="reports">
          <div className="chart">
            <h4>Rooms that have been booked.</h4>
            <div className="pieChart">{roomTypesList}</div>
          </div>

          <div className="reservationsProfits">
            <h4>Reservations Profits.</h4>
            <div className="profitsData">
              <div className="reservationsNumber">
                <h1>{this.state.reservations.length}</h1>
                <h5>Reservations</h5>
              </div>
              <div className="profitsAmount">
                <h1>{totalProfits}$</h1>
              </div>
            </div>
            <div className="printProfits">
              <button
                className="btn btn-primary"
                onClick={() =>
                  this.printReservationsStats(this.props.match.params.username)
                }
              >
                Print Reservations Stats
              </button>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default UserProfile;
