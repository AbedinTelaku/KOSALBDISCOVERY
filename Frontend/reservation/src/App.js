import Reservation from "./components/Reservation";
import Navbar from "./components/Navbar";
import Businesses from "./components/Businesses";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

function App() {
  return (
    <Router>
      <div className="App">
        <Navbar />
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
          </Switch>
        </div>
      </div>
    </Router>
  );
}

export default App;
