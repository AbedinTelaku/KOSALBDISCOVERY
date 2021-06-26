import React, { Component } from "react";
import Business from "./Business";

class Businesses extends Component {
  constructor(props) {
    super(props);
    this.state = {
      businesses: [],
      cities: [],
    };
  }

  componentDidMount() {
    fetch("http://localhost:8080/api/register/business/get/all/businesses")
      .then((res) => res.json())
      .then((data) => {
        this.setState({ businesses: data });
      });

    fetch("http://localhost:8080/api/register/city/get/all/cities")
      .then((res) => res.json())
      .then((data) => {
        this.setState({ cities: data });
      });
  }

  /* getAllBusinesses() {
    fetch("http://localhost:8080/api/register/business/get/all/businesses")
      .then((res) => res.json())
      .then((data) => {
        this.setState({ businesses: data });
      });
  }

  getAllCities() {
    fetch("http://localhost:8080/api/register/city/get/all/cities")
      .then((res) => res.json())
      .then((data) => {
        this.setState({ cities: data });
      });
  }*/

  render() {
    const allCities = this.state.cities.map((city, i) => (
      <li key={i}>{city.name}</li>
    ));
    const allBusinesses = this.state.businesses.map((business) => (
      <Business
        key={business.id}
        id={business.id}
        name={business.name}
        address={business.city.name}
      />
    ));
    console.log(this.state.businesses);
    return (
      <div className="businessesContent">
        <div className="businessesSideNavBar">{allCities}</div>

        <div className="businesses">{allBusinesses}</div>
      </div>
    );
  }
}

export default Businesses;
