import React from 'react';
import CardItem from './CardItem';
import './Cards.css';

function Cards() {
    return (
        <div className='cards'>
            <h1>Những lộ trình đã được tạo</h1>
            <div className="cards__container">
                <div className="cards__wrapper">
                    <ul className="cards__items">
                        <CardItem 
                            src='images/pexels-enzo-muñoz-2663851.jpg'
                            text='Đạt học bổng loại A năm học 2021-2022'
                            label='Học tập'
                            path='target-1'
                            creator='Admin'
                            progress='19%'
                        />
                        <CardItem 
                            src='images/pexels-william-choquette-1954524.jpg'
                            text='Tập gym 3 lần một tuần'
                            label='Sức khỏe'
                            path='muctieudemo2'
                            creator='Admin'
                            progress='52%'
                            
                        />
                        <CardItem 
                            src='images/pexels-garvin-st-villier-3311574.jpg'
                            text='Tiết kiệm tiền mua xe mới'
                            label='Tài chính'
                            path='muctieudemo3'
                            creator='Admin'
                            progress='83%'
                        />
                        <CardItem 
                            src='images/lmht-1550832529125682515233.jpg'
                            text='Lên rank thách đấu Liên Minh Huyền Thoại'
                            label='Khác'
                            path='muctieudemo4'
                            creator='Admin'
                            progress='50%'
                        />
                    </ul>
                </div>
            </div>
        </div>
    )
}

export default Cards;
