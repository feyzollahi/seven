import React, { Component } from 'react'
import './SignUp.css';
import Header from './../Header';
import Footer from './../Footer';
import logo from './../images/logo/logov1.png'
import firstImage from './../images/images.png';
import secondImage from './../images/job.jpg';
import thirdImage from './../images/job4_f.jpg';
export default class SignUp extends Component {
  render() {
    return (
      <div>
        <div>
        <meta charSet="UTF-8" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="fonts/iransans-fonts/fonts.scss" />
        <link rel="stylesheet" type="text/css" href="mother.css" />
        <link rel="stylesheet" type="text/css" href="signUp.css" />
        <title>Title</title>
        <style dangerouslySetInnerHTML={{__html: "\n        body{\n            font-family: IRANSans;\n        }\n    " }} />
        <div style={{height: '100vh'}} >
          <Header/>
          <div className="jobOonjaMiddleBackGroundUser">
          </div>
          <div className="jobOonjaSignUpBody container-fluid">
            <div id="slideshow" style={{marginTop: '-60px'}}>
              <div className="slide-wrapper">
                <div className="slide"> <img src={firstImage} className="sel-image" /></div>
                <div className="slide"><img src={secondImage} className="sel-image" /></div>
                <div className="slide"><img src={thirdImage} className="sel-image" /></div>
                <div className="slide"><img src={thirdImage} className="sel-image" /></div>
              </div>
            </div>
            <div className="signup">
              <form action="">
                <div className="myform">
                  <p>نام</p>
                  <input type="text" name="firstname"   />
                </div>
                <div className="myform">
                  <p> نام خانوادکی</p>
                  <input type="text" name="lastname"   />
                </div>
                <div className="myform">
                  <p>نام کاربری</p>
                  <input type="text" name="lastname"   />
                </div>
                <div className="myform">
                  <p>کلمه عبور</p>
                  <input type="password" name="lastname"   />
                </div>
                <div className="myform">
                  <p>تکرار کلمه عبور</p>
                  <input type="password" name="lastname"   />
                </div>
                <div className="myform">
                  <p>عنوان شغلی</p>
                  <input type="text" name="lastname"   />
                </div>
                <div className="myform2">
                  <p>ارسال عکس</p>
                  <input type="submit" name="lastname" defaultValue="ارسال عکس" />
                </div>
                <div className="bio">
                  <p>بیوگرافی</p>
                  <textarea style={{height: '100%', width: '500px'}} placeholder="خودتان را معرفی کنید" defaultValue={""} />
                </div>
                <div className="submit2">
                  <input type="submit" defaultValue="ثبت نام" />
                </div>
              </form> 
            </div>
            <div className="discription-div">
            </div>
            <Footer/>
          </div>
        </div></div>
      </div>
    )
  }
}
