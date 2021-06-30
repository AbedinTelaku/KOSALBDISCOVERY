import React, { Component } from "react";
import { FaCheck } from "react-icons/fa";
import axios from "axios";

class Room extends Component {
  state = {
    id: this.props.id,
    type: this.props.type,
    price: this.props.price,
    discount: this.props.discount,
    businessUsername: this.props.businessUsername,
    businessName: this.props.businessName,
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
  showPayButton(
    price,
    businessName,
    roomType,
    businessUsername,
    checkinDate,
    checkoutDate
  ) {
    axios
      .post("http://localhost:7000/payment/get/data", {
        amount: price,
        hotel: businessName,
        roomType: roomType,
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

    console.log(this.state.checkinDate);
    //current Date and Time (date/time when reservation is done)
    let myCurrentDate = new Date();
    let date = myCurrentDate.getDate();
    let month = myCurrentDate.getMonth() + 1;
    let year = myCurrentDate.getFullYear();

    let fullDate = `${year}-${month < 10 ? `0${month}` : `${month}`}-${date}`;

    var currenttime =
      myCurrentDate.getHours() +
      ":" +
      myCurrentDate.getMinutes() +
      ":" +
      myCurrentDate.getSeconds();

    axios({
      method: "post",
      url: "http://localhost:7000/payment/get/reservation",
      data: {
        time: currenttime,
        date: fullDate,
        checkInDate: checkinDate,
        checkOutDate: checkoutDate,
        businessUsername: businessUsername,
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
          <img
            src="https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F28%2F2017%2F10%2Fliving-room-hotel-president-wilson-geneva-EXPENSIVESUITE1017.jpg"
            alt="pht1"
          />
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
              onChange={(event) =>
                this.setState({ checkinDate: event.target.value })
              }
            />
            <label htmlFor="checkOutDate">Check Out</label>
            <input
              type="date"
              id="checkOutDate"
              onChange={(event) =>
                this.setState({ checkoutDate: event.target.value })
              }
            />
          </div>
          <div className="submit">
            <input
              type="submit"
              value="Book Now"
              // onClick={this.showPayButton}
              onClick={() =>
                this.showPayButton(
                  this.state.price,
                  this.state.businessName,
                  this.state.type,
                  this.state.businessUsername,
                  this.state.checkinDate,
                  this.state.checkoutDate
                )
              }
            />

            <div></div>
          </div>
        </div>
      </div>
    );
  }
}

export default Room;
