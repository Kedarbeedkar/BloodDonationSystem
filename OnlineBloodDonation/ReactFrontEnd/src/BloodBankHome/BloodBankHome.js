import React from "react";
import mystore from "../Reducer/mystore";
import { BrowserRouter, Link, Route, Switch } from "react-router-dom";
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import DonorInformation from "./DonerInformation";
import HospitalInformation from "./HospitalInformation";
import BloodRequestStatus from "./BloodRequestStatus";
import BloodBank from "../Images/bloodbank.jpg";
export default class BloodBankHome extends React.Component {
    constructor(props) {
        super(props);
    }
    logout = () => {
        mystore.dispatch({ type: "LOGGEDOUT" });
        localStorage.removeItem("loggedinuser");
        this.props.history.push("/");
    };

    render() {
        return (
            <div>
                <div>
                    <h1>Welcome {JSON.parse(localStorage.getItem("loggedinuser")).name}</h1>
                </div>
                <BrowserRouter>
                    <div>
                        <center>
                            <div class="topnav" id="mytopnav">
                                <Navbar bg="dark" variant="dark">
                                    <Container>
                                        <Navbar.Brand>Blood Bank Menu</Navbar.Brand>
                                        <Nav className="me-auto">
                                            <Nav.Link>
                                                <Link to="/DonorInformation" style={{ marginLeft: "60px" }} class="text-decoration-none text-white">
                                                    Donor Information
                                                </Link>
                                            </Nav.Link>
                                            <Nav.Link>
                                                <Link to="/HospitalInformation" style={{ marginLeft: "60px" }} class="text-decoration-none text-white">
                                                    Hospital Information
                                                </Link>
                                            </Nav.Link>
                                            <Nav.Link>
                                                <Link to="/BloodRequestStatus" style={{ marginLeft: "60px" }} class="text-decoration-none text-white">
                                                    Blood Request Status
                                                </Link>
                                            </Nav.Link>
                                            <Nav.Link href="/" onclick={this.logout} style={{ marginLeft: "60px" }} class="text-decoration-none text-white">
                                                Logout
                                            </Nav.Link>
                                        </Nav>
                                    </Container>
                                </Navbar>
                            </div>
                            <div>
                                <Switch>
                                    <div>
                                        <Route path="/DonorInformation" component={DonorInformation} exact />
                                        <Route path="/HospitalInformation" component={HospitalInformation} exact />
                                        <Route path="/BloodRequestStatus" component={BloodRequestStatus} />
                                    </div>
                                </Switch>
                            </div>
                        </center>
                    </div>
                </BrowserRouter>

                <div style={{ textAlign: "center" }}>
                    <img src={BloodBank} alt="this is blooddonation image" />
                </div>
            </div>
        );
    }
}
