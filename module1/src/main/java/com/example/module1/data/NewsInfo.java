package com.example.module1.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Zhao Chenping
 * @creat 2017/8/21.
 * @description
 */

public class NewsInfo {


    @SerializedName("T1348648756099")
    private List<NewsInfoBean> NewsInfoBean;

    public List<NewsInfoBean> getNewsInfoBean() {
        return NewsInfoBean;
    }

    public void setNewsInfoBean(List<NewsInfoBean> NewsInfoBean) {
        this.NewsInfoBean = NewsInfoBean;
    }

    public static class NewsInfoBean {
        /**
         * template : recommend
         * lmodify : 2017-08-21 09:20:48
         * source : 上海证券报·中国证券网
         * postid : CSBMOLLE002580S6
         * title : 新股提示:中国出版等3股上市 中大力德中签率公布
         * mtime : 2017-08-21 09:20:48
         * hasImg : 1
         * topic_background : http://img2.cache.netease.com/m/newsapp/reading/cover1/C1348648727071.jpg
         * digest : 周一(8月21日)新股提示：申购：无上市：中国出版、中宠股份、中环环保中签号及缴款：无中签率：中大力德【定位分析】中国出版8月21日上交所上市定位分析根据交易所
         * boardid : money_bbs
         * alias : Business
         * hasAD : 1
         * imgsrc : http://cms-bucket.nosdn.127.net/d6f02fbb19c24c358ce5ba9cedb1ebcd20170821091913.png
         * ptime : 2017-08-21 08:11:34
         * daynum : 17399
         * hasHead : 1
         * order : 1
         * votecount : 0
         * hasCover : false
         * docid : CSBMOLLE002580S6
         * tname : 财经
         * url_3w : http://money.163.com/17/0821/08/CSBMOLLE002580S6.html
         * priority : 95
         * url : http://3g.163.com/money/17/0821/08/CSBMOLLE002580S6.html
         * ads : [{"docid":"CSB86BR3002580S6","subtitle":"","skipType":"doc","skipID":"CSB86BR3002580S6","tag":"doc","title":"新列车运行图9月实施 商运速度将全球最快 ","imgsrc":"http://cms-bucket.nosdn.127.net/c114f954bada4ae58a6b45bf891fd72220170821075017.jpeg","url":"CSB86BR3002580S6"}]
         * ename : caijing
         * replyCount : 0
         * ltitle : 新股提示:中国出版等3股上市 中大力德中签率公布
         * hasIcon : true
         * subtitle :
         * cid : C1348648727071
         */

        private String template;
        private String lmodify;
        private String source;
        private String postid;
        private String title;
        private String mtime;
        private int hasImg;
        private String topic_background;
        private String digest;
        private String boardid;
        private String alias;
        private int hasAD;
        private String imgsrc;
        private String ptime;
        private String daynum;
        private int hasHead;
        private int order;
        private int votecount;
        private boolean hasCover;
        private String docid;
        private String tname;
        private String url_3w;
        private int priority;
        private String url;
        private String ename;
        private int replyCount;
        private String ltitle;
        private boolean hasIcon;
        private String subtitle;
        private String cid;
        private List<AdsBean> ads;

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMtime() {
            return mtime;
        }

        public void setMtime(String mtime) {
            this.mtime = mtime;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getTopic_background() {
            return topic_background;
        }

        public void setTopic_background(String topic_background) {
            this.topic_background = topic_background;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getDaynum() {
            return daynum;
        }

        public void setDaynum(String daynum) {
            this.daynum = daynum;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getUrl_3w() {
            return url_3w;
        }

        public void setUrl_3w(String url_3w) {
            this.url_3w = url_3w;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public String getLtitle() {
            return ltitle;
        }

        public void setLtitle(String ltitle) {
            this.ltitle = ltitle;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public static class AdsBean {
            /**
             * docid : CSB86BR3002580S6
             * subtitle :
             * skipType : doc
             * skipID : CSB86BR3002580S6
             * tag : doc
             * title : 新列车运行图9月实施 商运速度将全球最快
             * imgsrc : http://cms-bucket.nosdn.127.net/c114f954bada4ae58a6b45bf891fd72220170821075017.jpeg
             * url : CSB86BR3002580S6
             */

            private String docid;
            private String subtitle;
            private String skipType;
            private String skipID;
            private String tag;
            private String title;
            private String imgsrc;
            private String url;

            public String getDocid() {
                return docid;
            }

            public void setDocid(String docid) {
                this.docid = docid;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getSkipType() {
                return skipType;
            }

            public void setSkipType(String skipType) {
                this.skipType = skipType;
            }

            public String getSkipID() {
                return skipID;
            }

            public void setSkipID(String skipID) {
                this.skipID = skipID;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
