pragma solidity ^0.4.1;

import "strings.sol";

contract SimpleTwitter {
    using strings for *;

    address public developer;
    uint16 public maxTweetLength;
    uint16 public maxNameLength;

    struct Tweet {
        address authorAddress;
        string name;
        string text;
        uint date;
    }

    Tweet[] public tweets;

    event onTweetAdded(address authorAddress, string name, string text, uint date, uint tweetKey);

    modifier onlyDeveloper() {
        if (msg.sender != developer) throw;
        _;
    }

    function SimpleTwitter() {
        maxTweetLength = 140;
        maxNameLength = 20;
        developer = msg.sender;
    }

    function addTweet(string name, string text) {
        if (name.toSlice().len() > maxNameLength) throw;
        if (text.toSlice().len() > maxTweetLength) throw;

        tweets.push(Tweet(msg.sender, name, text, now));
        onTweetAdded(msg.sender, name, text, now, tweets.length - 1);
    }

    function getSettings() constant returns(uint16, uint16) {
        return (maxNameLength, maxTweetLength);
    }

    function setSettings(uint16 _maxNameLength, uint16 _maxTweetLength) onlyDeveloper {
        maxNameLength = _maxNameLength;
        maxTweetLength = _maxTweetLength;
    }
}