import React, { Component } from "react";
import axios from "axios";
import { Redirect } from "react-router-dom";

class Login extends Component {
  state = {
    username: "",
    password: "",
    authenticated: false,
  };

  login(usern, passw) {
    if (usern == "" || passw == "") {
      alert("Please fill required fields.");
    } else {
      axios
        .post("http://localhost:9000/api/register/authenticate/signIn", {
          username: usern,
          password: passw,
        })
        .then(
          (response) => {
            if (response.data.username === "not found") {
              console.log(this.state.authenticated);

              alert("Username or Password is incorrect.");
            } else {
              this.setState({ authenticated: true });
              console.log(this.state.authenticated);
              console.log(response.data.username);
              console.log(response.data.token);
              const token = response.data.token;

              document.cookie = "token=" + token + "; HttpOnly";
              localStorage.setItem("token", token);
              sessionStorage.setItem("token", token);
              console.log(document.cookie);
            }
          },
          (error) => {
            console.log(error);
          }
        );
    }
  }

  render() {
    if (this.state.authenticated == false) {
      return (
        <div className="loginContent">
          <div className="loginImg">
            <img src="logo.png" alt="" />
            <h3 className="appNameTitle">K O S A L B D I S C O V E R Y</h3>
          </div>
          <div className="loginForm">
            <div className="inputs">
              <input
                type="text"
                id="usernameInput"
                placeholder="username"
                onChange={(event) =>
                  this.setState({ username: event.target.value })
                }
              />

              <input
                type="password"
                id="passwordInput"
                placeholder="password"
                onChange={(event) =>
                  this.setState({ password: event.target.value })
                }
              />
            </div>
            <div className="buttons">
              <button
                className="btn btn-primary"
                onClick={() => {
                  this.login(this.state.username, this.state.password);
                }}
              >
                Log in
              </button>
            </div>
          </div>
        </div>
      );
    } else {
      return <Redirect to={"/profile/" + this.state.username} />;
    }
  }
}

export default Login;
