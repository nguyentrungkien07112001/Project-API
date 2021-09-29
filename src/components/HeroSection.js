import React from 'react';
import { Button } from './Button';
import './HeroSection.css';
import '../App.css';

function HeroSection() {
    return (
        <div className='hero-container'>
           <video src="/videos/pexels-alena-darmel-8141804.mp4" autoPlay loop muted /> 
           <h2>HOÀN THÀNH NHỮNG MỤC TIÊU MÌNH ĐẶT RA</h2>
           <p>Bạn còn chờ gì nữa?</p>
           <div className='hero-btns'>
               <Button 
                    href='sign-up'
                    className='btns' 
                    buttonStyle='btn--outline'
                    buttonSize='btn--large'>
                        Đăng ký
                </Button>
                <Button 
                    href='login'
                    className='btns' 
                    buttonStyle='btn--primary'
                    buttonSize='btn--large'>
                        Đăng nhập
                </Button>
           </div>
        </div>
    )
}

export default HeroSection
