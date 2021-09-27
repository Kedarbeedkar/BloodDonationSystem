import React from "react";
export default class DonerInformation extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            doner: [],
            display: "none",
        };
    }

    componentDidMount = () => {
        fetch("http://localhost:8080/getdonorall")
            .then((resp) => resp.json())
            .then((data) => {
                this.setState({ doner: data });
                console.log(data);
            });
    };

    render() {
        return (
            <div>
                <div>
                    <br />
                    <br />
                    <center>
                        <h1>Donor List</h1>
                    </center>
                    <table class="table table-bordered table-success">
                        <thead class="table table-dark">
                            <tr>
                                <th scope="col">DONORID</th>
                                <th scope="col">UID</th>
                                <th scope="col">NAME</th>
                                <th scope="col">GENDER</th>
                                <th scope="col">DATE OF BIRTH</th>
                                <th scope="col">BLOOD GROUP ID</th>
                                <th scope="col">CONTACT NUMBER</th>
                                <th scope="col">ADDRESS</th>
                                <th scope="col">CITY</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.doner.map((obj) => {
                                return (
                                    <tr>
                                        <td>{obj.donorid}</td>
                                        <td>{obj.uid.uid}</td>
                                        <td>{obj.name}</td>
                                        <td>{obj.gender}</td>
                                        <td>{obj.dob}</td>
                                        <td>{obj.bloodgroupid.bloodgroupid}</td>
                                        <td>{obj.contactno}</td>
                                        <td>{obj.address}</td>
                                        <td>{obj.city}</td>
                                    </tr>
                                );
                            })}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}
