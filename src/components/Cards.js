import axios from 'axios';
import React, { useState, useEffect } from 'react';
import CardItem from './CardItem';
import './Cards.css';

const Cards = () => {
    
    // const [targets, setTargets] = useState([]);
    // const [loading, setLoading] = useState(false);
    // const [currentPage, setCurrentPage] = useState(1);
    // const [targetsPerPage, setTargetsPerPage] = useState(10);

    // useEffect(() => {
    //     const fetchTargets = async () => {
    //         setLoading(true); 
    //         const res = await axios.get('https://614d5930e3cf1f001712d0b7.mockapi.io/api/v1/targets');
    //         setTargets(res.data);
    //         setLoading(false)
    //     }

    //     fetchTargets();
    // }, []); 
    
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

                    </ul>                    
                </div>
            </div>
        </div>
    )
};

export default Cards;

