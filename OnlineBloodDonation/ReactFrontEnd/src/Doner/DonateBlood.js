import React from "react";
import Form from "react-bootstrap/Form";

export default class DonateBlood extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            bloodgroupid: "",
            quantity: 0.0,
            donation_date: "",
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
                bloodgroupid: this.state.bloodgroupid,
                quantity: this.state.quantity,
                donation_date: this.state.donation_date,
            }),
        };

        fetch("http://localhost:8080/savedonation?bloodgroupid=" + this.state.bloodgroupid + "&quantity=" + this.state.quantity, reqData)
            .then((resp) => resp.json())
            .then((data) => this.setState({ st: data, success: true }));
        this.props.history.push("/donorhome");
    };

    render() {
        return (
            <div>
                <center>
                    <div>
                        <h1>Lifestream Blood Bank</h1>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 text-white" style={{ backgroundColor: "black" }}>
                            <br />
                            <h1>Blood Donation Form</h1>
                        </div>
                    </div>
                </center>
                <div class="row">
                    <div class="col-sm-12 bg-light">
                        <form onSubmit={this.submitReq}>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        Blood Group ID :
                                        <Form.Select aria-label="Floating label select example" name="bloodgroupid" onChange={this.handleChange}>
                                            <option>select Blood Group ID </option>
                                            <option value="1" id="bloodgroupid">
                                                A+
                                            </option>
                                            <option value="2" id="bloodgroupid">
                                                A-
                                            </option>
                                            <option value="3" id="bloodgroupid">
                                                AB+
                                            </option>
                                            <option value="4" id="bloodgroupid">
                                                AB-
                                            </option>
                                            <option value="5" id="bloodgroupid">
                                                B+
                                            </option>
                                            <option value="6" id="bloodgroupid">
                                                B-
                                            </option>
                                            <option value="7" id="bloodgroupid">
                                                O+
                                            </option>
                                            <option value="8" id="bloodgroupid">
                                                O-
                                            </option>
                                        </Form.Select>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="row">
                                    <div class="col">
                                        Quantity: <input type="number" name="quantity" class="form-control" placeholder="Enter quantity" onChange={this.handleChange} /> <br />
                                        <br />
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col">
                                    Date Of Donation : <input type="date" name="donation_date" onChange={this.handleChange} /> <br />
                                    <br />
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
