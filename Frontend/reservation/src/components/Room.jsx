import React, { Component } from "react";
import { FaCheck } from "react-icons/fa";
import axios from "axios";

class Room extends Component {
  state = {
    id: this.props.id,
    type: this.props.type,
    price: this.props.price,
    discount: this.props.discount,
    businessId: this.props.businessId,
    roomFeatures: [],
    checkinDate: "",
    checkoutDate: "",
  };

  componentDidMount() {
    fetch(
      "http://localhost:8080/api/register/roomFeature/get/all/" + this.state.id
    )
      .then((res) => res.json())
      .then((data) => {
        this.setState({ roomFeatures: data });
      });
  }
  wrapperFunction = () => {};
  showPayButton() {
    axios
      .post("http://localhost:7000/payment/get/data", {
        amount: 250,
        hotel: "Empire Hotel",
        roomType: "Suite",
        roomNumber: 20,
      })
      .then(
        (response) => {
          console.log(response);
          if (response.data === true) {
            window.open("http://localhost:7000/checkout");
          }
        },
        (error) => {
          console.log(error);
        }
      );

    var date = new Date();
    axios({
      method: "post",
      url: "http://localhost:7000/payment/get/reservation",
      data: {
        time: "20:00:00",
        date: date.getDate(),
        checkInDate: date.getDate(),
        checkOutDate: date.getDate(),
        roomId: 50,
        businessId: 20,
        touristUsername: "abedintelaku",
      },
    });
  }

  sendReservationData() {
    var date = new Date();
    axios({
      method: "post",
      url: "http://localhost:7000/payment/get/reservation",
      data: {
        time: "20:00:00",
        date: date.getDate(),
        checkInDate: date.getDate(),
        checkOutDate: date.getDate(),
        roomId: 50,
        businessId: 20,
        touristUsername: "abedintelaku",
      },
    });
  }
  getCheckInDate = (event) => {
    let val = event.target.value;
    this.setState({ checkinDate: val });
  };
  getCheckOutDate = (event) => {
    let val = event.target.value;
    this.setState({ checkoutDate: val });
  };

  render() {
    const roomF = this.state.roomFeatures.map((element, i) => (
      <p key={i}>
        {" "}
        <FaCheck className="checkIcon" /> {element.feature}
      </p>
    ));

    return (
      <div className="room">
        <div className="roomPhotos">
          <img src="" alt="pht1" />
        </div>
        <div className="roomInfo">
          <h4>{this.state.type}</h4>
          <div className="roomSpecifications">{roomF}</div>
          <div className="roomPrice">
            <h2>
              {this.state.price -
                this.state.price * (this.state.discount / 100)}
              €
            </h2>
            <h6 className="firstPrice">{this.state.price}€</h6>
            <h6 className="discount">
              {this.state.discount > 0 ? this.state.discount + "% Off" : ""}
            </h6>
            <h6 className="room-night">1 Room/Night</h6>
          </div>
          <div className="chooseDate">
            <label htmlFor="checkInDate">Check In</label>
            <input
              type="date"
              id="checkInDate"
              onChange={this.getCheckInDate}
            />
            <label htmlFor="checkOutDate">Check Out</label>
            <input
              type="date"
              id="checkOutDate"
              onChange={this.getCheckOutDate}
            />
          </div>
          <div className="submit">
            <input
              type="submit"
              value="Book Now"
              onClick={this.showPayButton}
            />

            <div></div>
          </div>
        </div>
      </div>
    );
  }
}

export default Room;
