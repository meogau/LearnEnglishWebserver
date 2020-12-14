import React from 'react'

function ViewBike() {
    return (
        <div>
            <div className="container">
        <div className="row">
            <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                <img src="/images/bike.jpg" className="img-responsive" alt="Image" />
            </div>
            <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">

                <div className="panel panel-info">
                    <div className="panel-heading">
                        <h3 className="panel-title">Bike Information</h3>
                    </div>
                    <div className="panel-body">
                        <span className="label label-info ">Bike Id :</span>
                        <p> - 123455677880809</p>
                        <span className="label label-info ">Bike name :</span>
                        <p> - Mountain Bike for Youth and Adult</p>
                        <span className="label label-info ">Status :</span>
                        <p> - Ready to rent</p>
                        <span className="label label-info ">Information :</span>
                        <p> - 26in Carbon Steel Mountain Bike, 21 Speed Fashion Student Bicycle Full Suspension MTB,
                            Lightweight and More Durable (Black) </p>
                        <span className="label label-info ">Price :</span>
                        <p> - 10.000 vnd/h</p>
                    </div>
                </div>
                <div className="row">
                    <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <button type="button" className="btn btn-primary">Rent 24 hours</button>
                    </div>
                    <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <button type="button" className="btn btn-success">Rent bike by hour</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
        </div>
    )
}

export default ViewBike
