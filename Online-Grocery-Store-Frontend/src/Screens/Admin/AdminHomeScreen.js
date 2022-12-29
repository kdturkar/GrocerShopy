import React from "react";
import { useSelector } from "react-redux";
import Header from "../../Components/Header";
const AdminHomeScreen = (props) => {
  const userSignIn = useSelector((store) => store.userSignIn);
  return (
    <div className="Screen">
      {!userSignIn.response && <Header title="You are not logged in" />}
      {userSignIn.response && (
        <Header title={"Welcome " + userSignIn.response.data.firstName} />
      )}
    </div>
  );
};

export default AdminHomeScreen;
