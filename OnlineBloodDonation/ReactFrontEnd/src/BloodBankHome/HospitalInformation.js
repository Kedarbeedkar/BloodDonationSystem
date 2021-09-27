import React from "react";
export default class HospitalInformation extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            hospital: [],
            display: "none",
        };
    }

    componentDidMount = () => {
        fetch("http://localhost:8080/getallhospital")
            .then((resp) => resp.json())
            .then((data) => {
                this.setState({ hospital: data });
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
                        <h1>Hospital List</h1>
                    </center>
                    <table class="table table-bordered table-success">
                        <thead class="table table-dark">
                            <tr>
                                <th scope="col">HOSPITALID</th>
                                <th scope="col">UID</th>
                                <th scope="col">NAME</th>
                                <th scope="col">ADDRESS</th>
                                <th scope="col">CITY</th>
                                <th scope="col">CONTACT NUMBER</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.hospital.map((obj) => {
                                return (
                                    <tr>
                                        <td>{obj.hospitalid}</td>
                                        <td>{obj.uid.uid}</td>
                                        <td>{obj.name}</td>
                                        <td>{obj.address}</td>
                                        <td>{obj.city}</td>
                                        <td>{obj.contactno}</td>
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
