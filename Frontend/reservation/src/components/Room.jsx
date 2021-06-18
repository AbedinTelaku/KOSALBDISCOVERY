import React, { Component } from "react";
import { FaCheck } from "react-icons/fa";
class Room extends Component {
  state = {
    id: this.props.id,
    type: this.props.type,
    price: this.props.price,
    discount: this.props.discount,
    roomFeatures: [],
  };

  componentDidMount() {
    fetch("http://localhost:8080/roomFeature/get/all/" + this.state.id)
      .then((res) => res.json())
      .then((data) => {
        this.setState({ roomFeatures: data });
      });
  }
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
            <input type="date" id="checkInDate" />
            <label htmlFor="checkOutDate">Check Out</label>
            <input type="date" id="checkOutDate" />
          </div>
          <div className="submit">
            <input type="submit" value="Book Now" />
          </div>
        </div>
      </div>
    );
  }
}

export default Room;
