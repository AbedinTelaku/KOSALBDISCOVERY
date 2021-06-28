import Reservation from "./components/Reservation";
import Navbar from "./components/Navbar";
import Businesses from "./components/Businesses";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import UserProfile from "./components/UserProfile";

function App() {
  return (
    <Router>
      <div className="App">
        <Navbar username="empireHotel" />
        <div className="appContent">
          <Switch>
            <Route
              path="/rooms/:id"
              name="Reservation"
              component={Reservation}
            ></Route>

            <Route path="/businesses">
              <Businesses />
            </Route>

            <Route
              path="/profile/:username"
              name="UserProfile"
              component={UserProfile}
            ></Route>
          </Switch>
        </div>
      </div>
    </Router>
  );
}

export default App;
