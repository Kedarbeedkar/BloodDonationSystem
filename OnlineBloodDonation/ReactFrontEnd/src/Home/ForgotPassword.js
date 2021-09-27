import React from "react";
import Form from "react-bootstrap/Form";
export default class DonorRegistartion extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            emailid: "",
            answer: "",
            password: "",
            st: {},
            success: false,
        };
    }

    handleChange = (e) => {
        let nm = e.target.name;
        let val = e.target.value;
        //alert(nm+":"+val)
        this.setState({ [nm]: val });
    };

    submitReq = (e) => {
        console.log(this.state);
        e.preventDefault();
        //console.log(this.state);
        const reqData = {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                emailid: this.state.emailid,
                answer: this.state.answer,
                password: this.state.password,
            }),
        };

        fetch("http://localhost:8080/changepassword", reqData)
            .then((resp) => resp.json())
            .then((data) => this.setState({ st: data, success: true }));
        this.props.history.push("/login");
    };

    render() {
        return (
            <div style={{ margin: 100 }}>
                <center>
                    <div>
                        <h1>Lifestream Blood Bank</h1>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 text-white" style={{ backgroundColor: "black" }}>
                            <br />
                            <h1>Forgot Password</h1>
                        </div>
                    </div>
                </center>
                <div class="row">
                    <div class="col-sm-12 bg-light">
                        <form onSubmit={this.submitReq} style={{ margin: 100 }}>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        <br />
                                        EmailID : <input type="text" name="emailid" class="form-control" placeholder="Enter Email ID" onChange={this.handleChange} /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <label for="squestionid">Security Question : </label>
                                <Form.Select aria-label="Floating label select example" name="squestionid" onChange={this.handleChange}>
                                    <option>select Question </option>
                                    <option value="1" id="squestionid">
                                        {" "}
                                        What is your country name?
                                    </option>
                                    <option value="2" id="squestionid">
                                        which was your favorite subject ?
                                    </option>
                                    <option value="3" id="squestionid">
                                        which is your favorite book?
                                    </option>
                                </Form.Select>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        Answer : <input type="text" name="answer" class="form-control" placeholder="Enter Answer" onChange={this.handleChange} /> <br /> <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        New Password : <input type="password" name="password" class="form-control" placeholder="Enter New Password" onChange={this.handleChange} /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <input type="submit" value="Submit" />
                            </div>
                        </form>
                        <br />
                        <br />
                    </div>
                </div>
            </div>
        );
    }
}
