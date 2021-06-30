<template>
  <div class="out">
    <el-table
      :data="tableData"
      :row-class-name="highlightRow"
      highlight-current-row
      @current-change="focusRow"
    >
      <el-table-column prop="number" label="序号" width="100">
      </el-table-column>
      <el-table-column prop="id" label="终端编号" width="100">
      </el-table-column>
      <el-table-column prop="name" label="名称" width="100"> </el-table-column>
      <el-table-column prop="type" label="终端类型" width="100">
      </el-table-column>
      <el-table-column prop="position" label="终端位置" width="100">
      </el-table-column>
      <el-table-column prop="LatitudeLongitude" label="经纬度" width="150">
      </el-table-column>
      <el-table-column prop="mac" label="终端mac" width="100">
      </el-table-column>
      <el-table-column prop="state" label="状态" width="100"> </el-table-column>
      <el-table-column prop="person" label="创建人" width="100">
      </el-table-column>
      <el-table-column prop="date" label="操作日期" width="100">
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
export default {
  data() {
    return {
      tableData: [
        {
          number: 0,
          id: 0,
          name: "我的大宝贝",
          type: "还不错",
          position: "曹县",
          LatitudeLongitude: "115.98 40.196",
          mac: "asdg12y3",
          state: "在线",
          person: "柳",
          date: "2021.6.23",
        },
        {
          number: 1,
          id: 1,
          name: "我的二宝贝",
          type: "一般",
          position: "武汉",
          LatitudeLongitude: "96.98 10.196",
          mac: "aasdaf",
          state: "离线",
          person: "杨",
          date: "2021.6.23",
        },
        {
          number: 2,
          id: 2,
          name: "我的三宝贝",
          type: "拉跨",
          position: "北京",
          LatitudeLongitude: "66.66 166.166",
          mac: "asirfuhaif",
          state: "未激活",
          person: "魏",
          date: "2021.6.23",
        },
      ],
      currentRow: null,
    };
  },
  methods: {
    highlightRow(data) {
      let row = data.row;
      if (row.state == "在线") {
        return "online-row";
      } else if (row.state == "离线") {
        return "offline-row";
      } else {
        return "warning-row";
      }
    },
    focusRow(data) {
      this.currentRow = data;
    },
  },
};
</script>

<style scoped>
.el-table >>> .online-row {
  background-color: #e1f3d8;
}
.el-table >>> .offline-row {
  background-color: #e9e9eb;
}
.el-table >>> .warning-row {
  background-color: #fde2e2;
}
.el-table >>> .current-row ::before {
  display: block;
  content: "";
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 10%);
}
.el-table >>> td {
  background-color: initial !important;
}
</style>
