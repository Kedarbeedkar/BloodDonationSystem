import React from "react";
import mystore from "../Reducer/mystore";

class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            emailid: "",
            password: "",
            user: {},
            donor: {},
            bloodbank: {},
            hospital: {},
            loginerror: "",
        };
    }

    handleChange = (e) => {
        let nm = e.target.name;
        let val = e.target.value;
        this.setState({ [nm]: val });
    };

    submitData = (e) => {
        e.preventDefault();
        console.log(this.state);
        const reqData = {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                emailid: this.state.emailid,
                password: this.state.password,
            }),
        };

        fetch("http://localhost:8080/checklogin", reqData)
            .then((resp) => resp.text())
            .then((data) => {
                if (data.length != 0) {
                    const json = JSON.parse(data);
                    if (json.uid.rollid == "1") {
                        this.setState({ bloodbank: json });
                        localStorage.setItem("loggedinuser", JSON.stringify(this.state.bloodbank));
                        mystore.dispatch({ type: "LOGGEDIN" });
                        this.props.history.push("/bloodbankhome");
                    } else if (json.uid.rollid == "2") {
                        this.setState({ donor: json });
                        localStorage.setItem("loggedinuser", JSON.stringify(this.state.donor));
                        mystore.dispatch({ type: "LOGGEDIN" });
                        this.props.history.push("/donorhome");
                    } else if (json.uid.rollid == "3") {
                        this.setState({ hospital: json });
                        localStorage.setItem("loggedinuser", JSON.stringify(this.state.hospital));
                        mystore.dispatch({ type: "LOGGEDIN" });
                        this.props.history.push("/hospitalhome");
                    }
                } else {
                    console.log(this.state);
                    this.setState({ loginerror: "Wrong User ID Password" });
                }
            });
    };
    render() {
        return (
            <div style={{ margin: 100 }}>
                <h1>User Login</h1>
                <form>
                    <div class="row">
                        <div class="col">
                            <br />
                            EmailID : <input type="text" name="emailid" class="form-control" placeholder="Enter Email ID" onChange={this.handleChange} /> <br />
                            <br />
                        </div>
                    </div>

                    <div>
                        <div class="row">
                            <div class="col">
                                Password : <input type="password" name="password" class="form-control" placeholder="Enter Password" onChange={this.handleChange} /> <br />
                                <br />
                            </div>
                        </div>
                        <input type="submit" value="Login" onClick={this.submitData} />
                    </div>
                </form>
                <p> {this.state.loginerror} </p>
            </div>
        );
    }
}
export default Login;
