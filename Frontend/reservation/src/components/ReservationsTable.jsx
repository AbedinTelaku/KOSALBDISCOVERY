import React, { Component } from "react";

class ReservationsTable extends Component {
  state = {
    reservations: [],
    id: "",
    checkindate: "",
    checkoutdate: "",
    roomtype: "",
    roomnumber: "",
    roomprice: "",
    discount: "",
    totalprice: "",
    touristname: "",
    touristusername: "",
    touristemail: "",
  };

  componentDidMount() {
    fetch(
      "http://localhost:8008/api/reservation/get/reservations/" +
        this.props.username
    )
      .then((res) => res.json())
      .then((data) => {
        this.setState({ reservations: data });
      });
  }

  render() {
    console.log(this.state.reservations);
    const reservationsList = this.state.reservations.map((reservation) => (
      <table className="table table-striped reservationsTable">
        <thead>
          <tr>
            <th style={{ "border-left": "1px solid lightgray" }}>ID</th>
            <th>Checkin Date</th>
            <th>checkout Date</th>
            <th>Room Type</th>
            <th>Room Number</th>
            <th>Room Price</th>
            <th>Discount</th>
            <th>Total Price</th>
            <th>Tourist Name</th>
            <th>Tourist Username</th>
            <th>Tourist Email</th>
            <th>Edit</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td style={{ "border-left": "1px solid lightgray" }}>
              {reservation.id}
            </td>
            <td>{reservation.checkInDate}</td>
            <td>{reservation.checkOutDate}</td>
            <td>{reservation.room.roomType}</td>
            <td>{reservation.room.roomNumber}</td>
            <td>{reservation.room.roomPrice}€</td>
            <td>{reservation.room.roomDiscount}%</td>
            <td>{reservation.totalPrice}€</td>
            <td>{reservation.tourist.touristName}</td>
            <td>{reservation.tourist.touristUsername}</td>
            <td>{reservation.tourist.touristEmail}</td>
            <td>
              <button className="btn btn-warning">Edit</button>
            </td>
            <td>
              <button className="btn btn-danger">Delete</button>
            </td>
          </tr>
        </tbody>
      </table>
    ));
    return (
      <div>
        <h5>Reservations</h5>
        {reservationsList}
      </div>
    );
  }
}

export default ReservationsTable;
